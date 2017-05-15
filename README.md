mvn clean compile assembly:single

https://tekcloud.atlassian.net/rest/api/2/search?jql=project%20in%20(tek,new)+AND+(MyField+is+empty+OR+myField+is+not+null)&fields=customfield_10117

https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in(tek,new)&fields=customfield_10117&fields=customfield_10119&fields=created

Count
https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in(tek,new)&fields=*none 

Customer's query
https://tekcloud.atlassian.net/rest/api/2/search?jql=project+in+(TPSVC,CSEL)+AND+issuetype+in+(%22Change+Request%22,+%22Customer+Rule%22,+Defect,+Dictionary,+Project,+%22QA+Testing%22,+Release,+%22Technical+Coding+/+Config%22,+%22QA+Task%22)+AND+created+%3E%3D+2017-04-01+ORDER+BY+created+DESC&startAt=0&maxResults=10000&fields=key,issuetype,status,priority,resolution,created,updated,lastViewed,resolutiondate,components,customfield_11010,customfield_15411,customfield_19611,customfield_10057,customfield_10056,customfield_15210,customfield_14018,customfield_11712