@Library('workshop@library')_

node (linux) {
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
