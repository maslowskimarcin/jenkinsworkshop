def call(def version){
    currentBuild.displayName = "#${BUILD_NUMBER}-v.${version}"
}
