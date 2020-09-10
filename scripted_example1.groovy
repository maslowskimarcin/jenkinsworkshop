<<<<<<< HEAD
=======
@Library('workshop@library')_
>>>>>>> 5f1bcd33873563cefad8272a437c2dd26dac87c3

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
<<<<<<< HEAD
}
=======
}
>>>>>>> 5f1bcd33873563cefad8272a437c2dd26dac87c3
