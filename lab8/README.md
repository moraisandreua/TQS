# TASK I

![password](https://i.imgur.com/SzNQzMH.png)

![install](https://i.imgur.com/pUEPN8t.png)

![user](https://i.imgur.com/8b5ARJL.png)

![configuration](https://i.imgur.com/VWlA8al.png)

![ready](https://i.imgur.com/WxjVpKi.png)

![install_plugins](https://i.imgur.com/OU1QoEu.png)

![config_jdk](https://i.imgur.com/7W5Ojs0.png)

![config_maven](https://i.imgur.com/nWeRCXt.png)

![config_git](https://i.imgur.com/Q2cM54o.png)

![config_build](https://i.imgur.com/6Iaa7Qj.png)

### Resultado depois do build
```
Started by user Administrator
Running as SYSTEM
Building in workspace /Users/andre/.jenkins/workspace/lab8-p1
The recommended git tool is: NONE
No credentials specified
Cloning the remote Git repository
Cloning repository /Users/andre/Documents/GitHub/TQS
 > git init /Users/andre/.jenkins/workspace/lab8-p1 # timeout=10
Fetching upstream changes from /Users/andre/Documents/GitHub/TQS
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
 > git fetch --tags --force --progress -- /Users/andre/Documents/GitHub/TQS +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url /Users/andre/Documents/GitHub/TQS # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
 > git rev-parse origin/master^{commit} # timeout=10
ERROR: Couldn't find any revision to build. Verify the repository and branch configuration for this job.
Finished: FAILURE
```

### Trocando o path para o projeto da aula passada

![aula7_p3_](https://i.imgur.com/DkuGXED.png)


# TASK II

![pipeline](https://i.imgur.com/N1OQLwg.png)

![jenkinsfile](https://i.imgur.com/2Ow6jqT.png)

### Resultado depois do build
```
Started by user Administrator
Lightweight checkout support not available, falling back to full checkout.
Checking out git https://github.com/moraisandreua/TQS.git into /Users/andre/.jenkins/workspace/lab8_pipeline@script to read lab7/P3_/Jenkinsfile
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential 52035288-be19-4b43-9a99-c4b63aa1a44e
Cloning the remote Git repository
Cloning repository https://github.com/moraisandreua/TQS.git
 > git init /Users/andre/.jenkins/workspace/lab8_pipeline@script # timeout=10
Fetching upstream changes from https://github.com/moraisandreua/TQS.git
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/moraisandreua/TQS.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url https://github.com/moraisandreua/TQS.git # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
Seen branch in repository origin/main
Seen 1 remote branch
 > git show-ref --tags -d # timeout=10
Checking out Revision 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 (origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 # timeout=10
Commit message: "jenkinsfile"
First time build. Skipping changelog.
Running in Durability level: MAX_SURVIVABILITY
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /Users/andre/.jenkins/workspace/lab8_pipeline
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Checkout SCM)
[Pipeline] checkout
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential 52035288-be19-4b43-9a99-c4b63aa1a44e
Cloning the remote Git repository
Cloning repository https://github.com/moraisandreua/TQS.git
 > git init /Users/andre/.jenkins/workspace/lab8_pipeline # timeout=10
Fetching upstream changes from https://github.com/moraisandreua/TQS.git
 > git --version # timeout=10
 > git --version # 'git version 2.31.1'
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/moraisandreua/TQS.git +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git config remote.origin.url https://github.com/moraisandreua/TQS.git # timeout=10
 > git config --add remote.origin.fetch +refs/heads/*:refs/remotes/origin/* # timeout=10
Avoid second fetch
Seen branch in repository origin/main
Seen 1 remote branch
 > git show-ref --tags -d # timeout=10
Checking out Revision 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 (origin/main)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 0ecbe9b2ca0fccde55768ab7cafec25e379ee793 # timeout=10
Commit message: "jenkinsfile"
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (test java installation)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ java -version
openjdk version "11.0.9.1" 2020-11-04 LTS
OpenJDK Runtime Environment Corretto-11.0.9.12.1 (build 11.0.9.1+12-LTS)
OpenJDK 64-Bit Server VM Corretto-11.0.9.12.1 (build 11.0.9.1+12-LTS, mixed mode)
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (test maven installation)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] sh
+ mvn -version
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: /Users/andre/.mvnvm/apache-maven-3.6.3
Java version: 11.0.9.1, vendor: Amazon.com Inc., runtime: /Users/andre/Library/Java/JavaVirtualMachines/correto/Contents/Home
Default locale: en_PT, platform encoding: UTF-8
OS name: "mac os x", version: "10.16", arch: "x86_64", family: "mac"
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```

Scheduling e update do Jenkinsfile
![scheduling](https://i.imgur.com/S0glCWD.png)

### Resultado depois do build
(depois de varios builds com failures relacionados com diretorios 😅)

![pipeline_new](https://i.imgur.com/ghDzbUs.png)

```
Started by user Administrator
Lightweight checkout support not available, falling back to full checkout.


[...]


Running in Durability level: MAX_SURVIVABILITY
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in /Users/andre/.jenkins/workspace/lab8_pipeline
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Checkout SCM)
[Pipeline] checkout


[...]


Commit message: "FIX Jenkinsfile"
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Tool Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Install)
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] tool
[Pipeline] envVarsForTool
[Pipeline] withEnv
[Pipeline] {
[Pipeline] dir
Running in /Users/andre/.jenkins/workspace/lab8_pipeline/lab7/P3_
[Pipeline] {
[Pipeline] sh
+ mvn clean install


[...]


[Pipeline] }
[Pipeline] // dir
Post stage
[Pipeline] junit
Recording test results
[Checks API] No suitable checks publisher found.
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS
```

# TASK III
![blueocean](https://i.imgur.com/A1DzPt4.png)

![blueocean_2](https://i.imgur.com/vWWHppf.png)

![blueocean_3](https://i.imgur.com/n3r5h6j.png)

![blueocean_4](https://i.imgur.com/JAKptWG.png)

# TASK IV

![setup_dockerfile](https://i.imgur.com/pCAyT8T.png)

![initialpassword](https://i.imgur.com/OBoVtgG.png)



