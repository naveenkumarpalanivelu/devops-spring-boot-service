pipeline {
    agent any
    environment {
        PATH = "/opt/aws/maven/bin:${env.PATH}"
    }
    stages {
        stage ("Maven: Clean and Install") {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ("Maven: Build Artifact") {
            steps {
                sh 'mvn package'
            }
        }
        stage ("Upload artifact to S3 bucket") {
            steps {
                s3Upload consoleLogLevel: 'INFO', dontSetBuildResultOnFailure: false, dontWaitForConcurrentBuildCompletion: false, entries: [[bucket: 'devops-demo-artifacts', excludedFile: '/target', flatten: false, gzipFiles: false, keepForever: false, managedArtifacts: false, noUploadOnFailure: false, selectedRegion: 'us-east-1', showDirectlyInBrowser: false, sourceFile: '**/target/AWS_Rest_Service.jar', storageClass: 'STANDARD', uploadFromSlave: false, useServerSideEncryption: false]], pluginFailureResultConstraint: 'FAILURE', profileName: 'S3-Artifacts', userMetadata: []
            }
        }
        stage("Ansible Init") {
            steps {
                script {
                    def tfHome = tool name: 'ansible'
                    env.PATH = "${tfHome}:${env.PATH}"
                    sh 'ansible --version'
                    sh 'python --version'
                }
            }
        }
        stage("Installing boto library for ansible playbook") {
            steps {
                sh 'pip3 install -U boto3'
                sh 'ansible --version'
                sh 'python --version'
            }
        }
        stage("Run backend ansible playbook") {
            steps {
                sh "ansible-playbook aws_backend_s3.yaml"
            }
        }
        stage("Docker stage") {
            steps {
                script {
                    def image_id = "$BUILD_NUMBER"
                    sh "cp docker-backend.yaml /tmp/devops-s3/target"
                    sh "cp Dockerfile /tmp/devops-s3/target"
                    sh "ansible-playbook /tmp/devops-s3/target/docker-backend.yaml --extra-vars image_id=${image_id}"
                }
            }
        }
    }
}