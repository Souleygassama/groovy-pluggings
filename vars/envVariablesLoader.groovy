import java.nio.file.Files
import java.nio.file.Paths

def call(String filePath = "/var/lib/jenkins/workspace/groovy-plugin/.env") {
    echo "RUNNING PROPS  ${filePath}"
    def envVars = [:]

     def currentDir = new File(".").absolutePath
    echo "Current Working Directory: ${currentDir}"

    if (Files.exists(Paths.get(filePath))) {
            echo "RUNNING PROPS2  ${filePath}"

        def lines = Files.readAllLines(Paths.get(filePath))
        lines.each { line ->
            if (line.trim() && !line.startsWith("#")) { // Ignore comments and empty lines
                def (key, value) = line.split("=", 2)
                envVars[key.trim()] = value.trim()

                echo key
            }
        }
    } else {
        error "ERROR: .env file not found at ${filePath}"
    }

    return envVars
}
