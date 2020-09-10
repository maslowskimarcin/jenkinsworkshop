pipeline{
    agent any
    stages{
        stage('Parallel test'){
            steps {
                parallel(
                        'Executor 1': {
                            echo "n1"
                        },
                        'Executor 2': {
                            echo "n2"
                        }
                )
            }
        stage('Dynamic Parallel test') {
            steps {
                script {
                    nodeNames = ["linux", "master"]
                    def runTestsMap = [:]
                    for (nodeName in nodeNames) {
                        runTestsMap["Node ${nodeName}"]={
                            node(nodeName) {
                                runTests()
                            }
                        }
                    }
                    parallel(runTestsMap)
                }
            }
            }

    }
}