import java.nio.file.Files
import java.nio.file.Paths

def call(String filePath = "../.env") {
    echo "RUNNING PROPS"
    def envVars = [:]
    
    if (Files.exists(Paths.get(filePath))) {
        def lines = Files.readAllLines(Paths.get(filePath))
        lines.each { line ->
            if (line.trim() && !line.startsWith("#")) { // Ignore comments and empty lines
                def (key, value) = line.split("=", 2)
                envVars[key.trim()] = value.trim()
            }
        }
    } else {
        error "ERROR: .env file not found at ${filePath}"
    }

    return envVars
}
