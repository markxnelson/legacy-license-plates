# Copyright (c) 2017 Oracle and/or its affiliates. All rights reserved.
#
#
import os

# Deployment Information 
domainhome = os.environ.get('DOMAIN_HOME', '/u01/oracle/user_projects/domains/base_domain')
admin_name = os.environ.get('ADMIN_NAME', 'AdminServer')
appname    = os.environ.get('APP_NAME', 'licenseplates')
apppkg     = os.environ.get('APP_PKG_FILE', 'licenseplates.war')
appdir     = os.environ.get('APP_PKG_LOCATION', '/u01/oracle')
admin_name = os.environ.get('ADMIN_NAME', 'AdminServer')
adminport = os.environ.get('ADMIN_PORT', '7001')
username = os.environ.get('ADMIN_USER', 'weblogic')
password = os.environ.get('ADMIN_PASSWORD', 'welcome1')
admin_url='t3://localhost:7001'

# Connect to the AdminServer.
connect(username, password, "t3://localhost:"+adminport)

print 'deploying....'

deploy(appname, appdir+'/'+apppkg, targets=admin_name)

startApplication(appname)

print 'disconnecting from admin server....'

disconnect()

exit()
