

node {
    stage('Build') {
        if (env.BRANCH_NAME == 'master') {
            echo 'Build master version'
            def version=build()
            echo "Promote to artifactory"
            promoteArtifactory(version)
        } else {
            echo 'I execute elsewhere'
        }
    }
}

def build(){
    echo "Build"
}

def promoteArtifactory(version){
    echo "Promoting artifactory ${version}"
}