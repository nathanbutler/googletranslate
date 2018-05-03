#!/usr/bin/env bash
curl --user ${CIRCLECI_KEY}: \
    --request POST \
    --form revision=ee30465f4408a00b38cf5da1cb2ce21dde58d2ba\
    --form config=@config.yml \
    --form notify=false \
        https://circleci.com/api/v1.1/project/github/nathanbutler/googletranslate/tree/master
