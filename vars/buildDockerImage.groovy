def call (String imageName, String dockerFilePath){
    echo "building Docker image ${imageName} from /var/lib/jenkins/workspace/sama-gp/${dockerFilePath}"
    docker.build (imageName, "--file "+dockerFilePath+" .")
    docker.image(imageName).push()
}
