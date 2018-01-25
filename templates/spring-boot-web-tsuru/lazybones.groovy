def props = [:]
props.group = ask("Define value for 'group' [br.gov.rj.campos]: ", "br.gov.rj.campos", "group")
props.version = ask("Define value for 'version' [0.1]: ", "0.1", "version")

println 'Just a simple name for the app'
String artifact = ask("Define value for 'artifact' [appname]: ", "appname", "artifact")
props.artifact = artifact.trim().toLowerCase()
//TODO replace com erro .replaceAll("[^a-z]","")​ -> No such property: ​ for class: java.lang.String 
println projectDir
props.projectDir = projectDir

props.pkg = props.group + "." + props.artifact
props.USER = "\$USER"
  
["build.gradle", "**/*.java", "pom.xml", "settings.gradle", "Procfile", "application-variables.env"].each {
  processTemplates(it, props)
}

// TODO Temos que mudar isso viu }=)
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