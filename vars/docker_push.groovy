def call(String ProjectName,String ImageTag,String dockerhubuser){
  withCredentials([userPassword('credentialsId:"dockerHubCred",passwordVariable:"dockerHubPass",usernameVariable:"dockerHubUser")]){
    sh "docker login -u ${dockerhubuser} -p {dockerhubpass} "
  }
  sh "docker push $(dockerhubuser)/${ProjectName}:${ImageTag} "
}
