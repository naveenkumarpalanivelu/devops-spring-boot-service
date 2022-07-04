pipeline {
    agent any
    environment {
        PATH = "/opt/aws/maven/bin:${env.PATH}"
    }
    stages {
        stage ("Clean and Install Maven packages") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ("Build Maven Artifacts") {
            steps {
                sh 'mvn package'
            }
        }
        stage ("Upload Maven artifacts to S3 bucket") {
            steps {
                s3Upload(file:'target/AWS_Rest_Service.jar', bucket:'devops-demo-artifacts', path:'target/AWS_Rest_Service.jar')
            }
        }
        stage("Add ansible to the Jenkins environment path") {
            steps {
                script {
                    def tfHome = tool name: 'ansible'
                    env.PATH = "${tfHome}:${env.PATH}"
                    sh 'ansible --version'
                    sh 'python --version'
                }
            }
        }
        stage("Install boto3 library for ansible playbook") {
            steps {
                sh 'pip3 install -U boto3'
                sh 'ansible --version'
                sh 'python --version'
            }
        }
        stage("Run ansible playbook to copy artifacts from S3 bucket") {
            steps {
                sh "ansible-playbook aws_backend_s3.yaml"
            }
        }
        stage("Build docker Image and push it to docker hub") {
            steps {
                script {
                    def image_id = "$BUILD_NUMBER"
                    sh "cp docker-backend.yaml /tmp/devops-s3/target"
                    sh "cp Dockerfile /tmp/devops-s3/target"
                    sh "ansible-playbook /tmp/devops-s3/target/docker-backend.yaml --extra-vars image_id=${image_id}"
                }
            }
        }
        stage('remove docker images after deployment') {
            steps {
                script {
                    def image_id = "$BUILD_NUMBER"
                    sh "docker image rm naveen24788/backend:${image_id}"
                    sh "docker image rm backend:${image_id}"
                }
            }
        }
        stage('Deploy backend microservice'){
            steps {
                withAWS(credentials: 'kubernetes-cluster', region: 'us-east-1') {
                    sh 'aws eks --region us-east-1 update-kubeconfig --name DevOpsEksCluster3'
                    sh 'kubectl set image deployment/backendservice backendservice=naveen24788/backend:$BUILD_NUMBER'
                    sh 'kubectl rollout restart deployment/backendservice'
                }
            }
        }
    }
}