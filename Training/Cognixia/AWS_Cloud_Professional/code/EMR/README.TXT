aws dynamodb batch-write-item --request-items file://ProductCatalog.json --no-verify-ssl
aws dynamodb batch-write-item --request-items file://Forum.json --no-verify-ssl
aws dynamodb batch-write-item --request-items file://Thread.json --no-verify-ssl
aws dynamodb batch-write-item --request-items file://Reply.json --no-verify-ssl