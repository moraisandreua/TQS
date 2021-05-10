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