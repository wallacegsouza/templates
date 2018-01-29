def props = [:]
props.group = ask("Define value for 'group' [br.gov.rj.campos]: ", "br.gov.rj.campos", "group")
props.version = ask("Define value for 'version' [0.1]: ", "0.1", "version")

println 'Just a simple name for the app'
String artifact = ask("Define value for 'artifact' [appname]: ", "appname", "artifact")
props.artifact = artifact.trim().toLowerCase()
//TODO replace com erro .replaceAll("[^a-z]","")​ -> No such property: ​ for class: java.lang.String

props.projectDir = projectDir

props.pkg = props.group + "." + props.artifact
props.USER = "\$USER"

["build.gradle", "**/*.java", "settings.gradle", "docker-compose.yml", "src/main/resources/application.yaml", "src/main/resources/db/migration/*.sql"].each {
  processTemplates(it, props)
}

// INFO To develop with Windows its needed to modify the separator.
String separator = "/"

def proj_name = props.artifact.toLowerCase()
def proj_group = (props.group.split("\\.")*.toLowerCase()).join(separator)

base_package = proj_group + separator + proj_name

def java_dir = [projectDir, "src", "main", "java", base_package].join(separator)

File dir_java_project = new File(java_dir)

def old_java_dir = [projectDir, "src", "main", "java"].join(separator)

import org.apache.commons.io.FileUtils

["controller", "entity", "repository", "service", "DemoApplication.java"].each { 
  FileUtils.moveToDirectory(new File(old_java_dir + separator + it), dir_java_project, true)
}

FileUtils.moveFile( 
  new File(projectDir, "gitignore.txt"),
  new File(projectDir, ".gitignore"))