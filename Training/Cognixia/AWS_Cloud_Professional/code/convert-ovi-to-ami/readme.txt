https://docs.aws.amazon.com/vm-import/latest/userguide/vmimport-image-import.html
https://docs.aws.amazon.com/vm-import/latest/userguide/vmie_prereqs.html#vmimport-role


aws configure -- to give aws key 

aws s3 ls --no-verify-ssl

Convert OVI to AMI :

https://virtuallymikebrown.com/2012/02/05/a-small-virtual-machine-for-a-test-lab/ --to get OVI


## Create a file named trust-policy.json on your computer. 
1. aws iam create-role --role-name vmimport --assume-role-policy-document "file://trust-policy.json"
## Create a file named role-policy.json 
2. aws iam put-role-policy --role-name vmimport --policy-name vmimport --policy-document "file://role-policy.json"
3. aws ec2 import-image --description "My Server OVA" --disk-containers "file://containers.json" --no-verify-ssl
4. aws ec2 describe-import-image-tasks --import-task-ids import-ami-02b54007dd1e27b26

