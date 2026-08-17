def call(String DockerHubUser, String ProjectName, String ImageTag){
  withCredentials([usernamePassword(credentialsId:"docker-login",usernameVariable:"dockerHubUser",passwordVariable:"dockerHubPass")]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${DockerHubUser}/${ProjectName}:${ImageTag}"
}
