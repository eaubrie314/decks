#!/bin/sh
aws dynamodb create-table \
  --table-name decks-table \
  --cli-input-json file://dynamodb/schema-decks.json \
  --region us-east-1 \
  --endpoint http://dynamodb:8000
tail -f /dev/null
