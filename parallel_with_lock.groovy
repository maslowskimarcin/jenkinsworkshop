@Library('workshop@library')_

pipeline{
    agent any
    stages{
        stage("Check trigger"){
           when { triggeredBy 'Branch indexing' }
           steps {
               error('Aborting the build caused by: Branch indexing')
           }
       }
        stage('Parallel test'){
            steps {
                parallel(
                        'Executor 1': {
                            lock('test') {
                                echo "test"
                            }
                            echo "n1 "
                        },
                        'Executor 2': {
                            lock('test') {
                                echo "test"
                            }
                            echo "n2"
                        }
                )
            }
        }
        stage('Dynamic Parallel test') {
            steps {
                script {
                    nodeNames = ["linux", "master"]
                    def runTestsMap = [:]
                    for (nodeName in nodeNames) {
                        runTestsMap["Node ${nodeName}"]={
                            node(nodeName) {
                                lock('test') {
                                    runTests()
                                }
                            }
                        }
                    }
                    parallel(runTestsMap)
                }
            }
        }
    }
}