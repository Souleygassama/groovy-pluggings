def call (String imageName, String dockerFilePath){
    echo "building Docker image ${imageName} from /var/lib/jenkins/workspace/sama-gp/${dockerFilePath}"
    docker.build (imageName, "--file "+dockerFilePath+" .")
    docker.withRegistry('https://index.docker.io/v1/', 'docker-hub-credentials') {
    def dockerUser = "souleygassama"
    def imageName = "sama-gp-annonce-image"
    def fullImageName = "${dockerUser}/${imageName}:latest"
        
    sh "docker tag ${imageName}:latest ${fullImageName}"
    docker.image(fullImageName).push()
        }
}
