def deployToK8s (String manifestRepo, String namespace){
    echo"Deploying to Kubernate cluster with manifest repository ${manifestRepo} in namespace ${namespace}"
    dir ('k8s-manifests'){
        git url: manifestRepo
    }
    sh "kubectl apply -f k8s-manifests/ --namespace=${namespace}"
}