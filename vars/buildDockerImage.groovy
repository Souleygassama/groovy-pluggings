def buildDockerImage(String imageName, String dockerFilePath){
    echo "building Docker image ${imageName} from ${dockerFilePath}"
    docker.build (imageName, dockerFilePath)
    docker.image(imageName).push()
}