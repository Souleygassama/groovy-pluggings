def configureK8sCluster (String clusterContext){
    echo " Setting Kubernates cluster context to ${clusterContext}"
    sh "kubectl config use-context ${clusterContext}"
}
