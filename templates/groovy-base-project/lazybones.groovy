def props = [:]
props.group = ask("Define value for 'group' [br.gov.rj.campos]: ", "br.gov.rj.campos", "group")
props.version = ask("Define value for 'version' [0.1]: ", "0.1", "version")
props.artifact = ask("Define value for 'artifact' [appname]: ", "appname", "artifact")

props.pkg = props.group + "." + props.artifact

processTemplates("build.gradle", props)
processTemplates("**/*.groovy", props)
processTemplates("**/*.java", props)

// TODO Temos que mudar isso viu }=)
String separator = "/"

def proj_name = props.artifact.toLowerCase()
def proj_group = (props.group.split("\\.")*.toLowerCase()).join(separator)

base_package = proj_group + separator + proj_name

def groovy_dir = [projectDir, "src", "main", "groovy", base_package].join(separator)

def java_dir = [projectDir, "src", "main", "java", base_package].join(separator)

File dir_groovy_project = new File(groovy_dir)
File dir_java_project = new File(java_dir)

def old_groovy_dir = [projectDir, "src", "main", "groovy"].join(separator)

def old_java_dir = new File([projectDir, "src", "main", "java", "domain"].join(separator))

import org.apache.commons.io.FileUtils

["controller", "domain", "init", "service", "AppNameApplication.groovy"].each { 
  FileUtils.moveToDirectory(new File(old_groovy_dir + separator + it), dir_groovy_project, true)
}

FileUtils.moveToDirectory(old_java_dir, dir_java_project, true)