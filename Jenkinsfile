@Library("Sharedlibrary") _
pipeline {
    agent {label "agentubuntu"}

    stages {
        stage('Hello') {
            steps {
                script{
                    hello()
                }
            }
        }
        
        stage("Code"){
            steps{
                clone("https://github.com/LondheShubham153/flask-app-ecs.git","main")
            }
        }
        
        stage("Build"){
            steps{
                echo "This is Building the code"
                docker_build("cmsingh007", "flask-app-ecs-image","v2")
               // sh "docker build -t flask-app-ecs-image:v1 ."
            } 
        }
        
        stage("Push to DockerHub"){
             steps{
                 echo "This is Pushing Image to the DockerHub"
                 docker_push("cmsingh007", "flask-app-ecs-image","v2")
            }           
        }
        
        stage("Deploy"){
            steps{
                echo "This is Deploying the code"
                docker_compose()
            }            
        }
        
    }
    
}


/*  Below was the first pipeline 
pipeline{
    
    agent {label "agentubuntu"}
    
    stages{
        stage("Code"){
            steps{
                echo "This is cloning the code"
               // git url: "https://github.com/LondheShubham153/flask-app-ecs.git", branch:"main"
                echo "Code cloning succesfully"
            }
        }
        stage("Build"){
            steps{
                echo "This is Building the code"
               // sh "docker build -t flask-app-ecs-image:v1 ."
            } 
        }
        stage("Push to DockerHub"){
             steps{
                 echo "This is Pushing Image to the DockerHub"
             //    withCredentials([usernamePassword(credentialsId:"docker-login",
             //    passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")])
             //    {
             //    sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
             //    sh "docker image tag flask-app-ecs-image:v1 ${env.dockerHubUser}/testingpage:v1"
             //    sh "docker push ${env.dockerHubUser}/testingpage:v1"
             //    }     
            }           
        }
        stage("Deploy"){
            steps{
                echo "This is Deploying the code"
               // sh "docker run -d -p 85:80 flask-app-ecs-image:v1"
               sh "docker compose up -d"
            }            
        }
    }
    
}
*/
