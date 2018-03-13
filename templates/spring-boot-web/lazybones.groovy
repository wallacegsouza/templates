// Questions
def props = [:]
// ref >> https://maven.apache.org/guides/mini/guide-naming-conventions.html
println 'The group will identify your project uniquely across all projects, so we need to enforce a naming schema'
props.group = ask("Define value for 'group' [br.gov.rj.campos]: ", "br.gov.rj.campos", "group")

props.version = ask("Define value for 'version' [0.1]: ", "0.1", "version")

println 'Just a simple name for the app'
String artifact = ask("Define value for 'artifact' [appname]: ", "appname", "artifact")
props.artifact = artifact.trim().toLowerCase()
//TODO replace com erro .replaceAll("[^a-z]","")​ -> No such property: ​ for class: java.lang.String

def mapPaas = ['t': "tsuru", 'a': "aws", 'g': "google", 'n': "none"]
println """
Define platform as a service:
t) tsuru
a) aws
g) google
n) none
"""
String aux = ask("value default is t: ", "t")
String paas = mapPaas[aux]

// Set properties for templates
props.projectDir = projectDir
props.pkg = props.group + "." + props.artifact

// Process Templates
["build.gradle",
  "**/*.groovy",
  "**/*.java",
  "settings.gradle",
  "docker-compose.yml",
  "src/main/resources/logback-spring.xml",
  "src/main/resources/application.yaml",
  "src/main/resources/db/migration/*.sql"].each {
  processTemplates(it, props)
}

// INFO To develop with Windows its needed to modify the separator.
String separator = "/"

def proj_name = props.artifact.toLowerCase()
def proj_group = (props.group.split("\\.")*.toLowerCase()).join(separator)

base_package = proj_group + separator + proj_name

def java_dir = [projectDir, "src", "main", "java", base_package].join(separator)
def groovy_test_dir = [projectDir, "src", "test", "groovy", base_package].join(separator)

File dir_java_project = new File(java_dir)
File dir_groovy_test_project = new File(groovy_test_dir)

def old_java_dir = [projectDir, "src", "main", "java"].join(separator)
def old_groovy_test_dir = [projectDir, "src", "test", "groovy"].join(separator)

import org.apache.commons.io.FileUtils

File old_java_dir_path = new File(old_java_dir)

old_java_dir_path.listFiles().each {
  FileUtils.moveToDirectory(it, dir_java_project, true)
}

File old_groovy_test_dir_path = new File(old_groovy_test_dir)

old_groovy_test_dir_path.listFiles().each {
  FileUtils.moveToDirectory(it, dir_groovy_test_project, true)
}

// Change the name of the files or directories
FileUtils.moveFile(
  new File(projectDir, "gitignore.txt"),
  new File(projectDir, ".gitignore"))

String paas_dir = [projectDir, "paas"].join(separator)

// Copy files form PAAS
if(paas && 'none' != paas) {
  FileUtils.forceDelete(new File(projectDir, ".gitlab-ci.yml"))
  def passFileDir = new File(paas_dir + separator + paas)
  passFileDir.listFiles().each {
    FileUtils.moveFileToDirectory(it, projectDir, true)
  }
}

// Delete unnecessary directories and files
FileUtils.deleteDirectory(new File(paas_dir))
FileUtils.deleteDirectory(new File(".lazybones"))

// Create .gradle directory form cache
new File([projectDir, ".gradle"].join(separator)).mkdirs()