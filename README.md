# json-diff-with-old-value


## simple example

source.json
```
{
  "a": 0,
  "b": [1,2],
  "d": "deleted",
  "e": "old"
}

```

target.json
```
{
  "b": [1,2,0],
  "c": "123",
  "e": "new"
}
```

result:
```
[
	{
		"op": "move",
		"from": "/a",
		"path": "/b/2",
		"oldValue": "0"
	},
	{
		"op": "remove",
		"path": "/d",
		"oldValue": "deleted"
	},
	{
		"op": "replace",
		"path": "/e",
		"value": "new",
		"oldValue": "old"
	},
	{
		"op": "add",
		"path": "/c",
		"value": "123"
	}
]
```

## complex example

(2 different production objects)

source.json
```
{
    "id": "6f93b1a0-a27b-4767-8ed4-8ad483597eb8",
    "modelType": "ArticleProduction",
    "state": "wstate:Created",
    "created": "2020-12-03T13:10:28.957Z",
    "createdBy": {},
    "modified": "2020-12-03T13:11:39.209Z",
    "modifiedBy": {},
    "appliesLicense": {
        "id": "4be93b90-2ee1-4e4d-933c-88b69c4d318b"
    },
    "hasWorkMap": {
        "modelType": "ResearchMap",
        "id": "bad8bd79-6de7-4a38-86df-4059d82a6afa"
    },
    "targetedProduct": {
        "modelType": "ArticleProduct",
        "state": "wstate:Created",
        "doi": "10.1111/chd.50918",
        "isPartOfPeriodical": {
            "modelType": "Journal",
            "id": "PD6748942"
        },
        "productCode": "CHD50918"
    },
    "usesWorkflow": "wwfl:ArticleStandardWorkflow",
    "cas": 1607001099227955200,
    "productionOf": {
        "modelType": "Submission",
        "id": "3fd16d37-92b6-4c0d-9be9-59444fcf43f9"
    },
    "_links": {
        "self": {
            "href": "http://cmh-production-api-qa.aws.wiley.com:8080/v1/productions/6f93b1a0-a27b-4767-8ed4-8ad483597eb8"
        }
    }
}
```

target.json
```
{
	"modelType": "ArticleProduction",
	"id": "36aae8e6-b399-4e6d-ab6b-508a538d1c76",
	"productionContact": [
		{
			"modelType": "Participant",
			"id": "e6dcec6d-3734-4580-bb6d-c1edb2497785",
			"givenName": "Oleg",
			"familyName": "Tkachenko",
			"orcId": "0000-0003-0888-1984"
		}
	],
	"appliesLicense": {
		"modelType": "CopyrightPolicy",
		"copyright": [
			{
				"htmLang": null,
				"htmValue": null
			}
		],
		"copyrightPolicyOf": {
			"modelType": "CopyrightTransferAgreement",
			"category": null,
			"dateSigned": null
		},
		"copyrightYear": null,
		"distributionModel": "Subscription",
		"license": {
			"modelType": null,
			"mnemonic": null
		}
	},
	"requiresPayment": [
		{
			"modelType": "Order",
			"paymentDate": null
		}
	],
	"targetedProduct": {
		"modelType": "ArticleProduct",
		"id": "15039392",
		"doi": "10.1111/chd.50915",
		"isPartOfPeriodical": {
			"id": "6748942",
			"modelType": "Journal"
		}
	},
	"hasWorkMap": {
		"modelType": "ResearchMap",
		"id": "80da1782-3410-4ba7-a0cc-dcb754712f61"
	},
	"status": "BOOKIN",
	"comment": [
		null
	],
	"commentProduction": [
		"Sanmiguel-Rojas, Enrique:http://orcid.org/0000-0003-0888-1984 add to AQF:missing GTOC"
	],
	"hasSchedule": {
		"modelType": "Schedule",
		"id": "288C8545-0AC9-211A-69C5-86BB1B6C3FF8",
		"state": "wstate:Created",
		"hasScheduleEvent": [
			{
				"modelType": "ScheduleEvent",
				"id": "2818",
				"modelEventType": {
					"id": "wevent:IssueCompilation",
					"mnemonic": "Issue Compilation"
				},
				"eventCode": "PRESS",
				"dateForecastOriginal": null,
				"dateForecastCurrent": null,
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2820",
				"modelEventType": {
					"id": "wevent:ProofedByAuthor",
					"mnemonic": "PRF RECD"
				},
				"eventCode": "FR_AU",
				"dateForecastOriginal": "2020-12-22",
				"dateForecastCurrent": "2020-12-22",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2826",
				"modelEventType": {
					"id": "wevent:ManuscriptReceivedInProduction",
					"mnemonic": "RECD at JWS"
				},
				"eventCode": "RECD",
				"dateForecastOriginal": "2020-12-03",
				"dateForecastCurrent": "2020-12-03",
				"dateCompleted": "2020-12-03"
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2832",
				"modelEventType": {
					"id": "wevent:ManuscriptToTypesetter",
					"mnemonic": "To TS"
				},
				"eventCode": "TO_TYPE",
				"dateForecastOriginal": "2020-12-07",
				"dateForecastCurrent": "2020-12-07",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2833",
				"modelEventType": {
					"id": "wevent:RevisedProofApproved",
					"mnemonic": "REV ART PRF APPR"
				},
				"eventCode": "UPGCXPRFAP",
				"dateForecastOriginal": "2020-12-29",
				"dateForecastCurrent": "2020-12-29",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2834",
				"modelEventType": {
					"id": "wevent:RevisedProofReceived",
					"mnemonic": "REV ART PRF RECD"
				},
				"eventCode": "FR_CXUNPAG",
				"dateForecastOriginal": "2020-12-28",
				"dateForecastCurrent": "2020-12-28",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2837",
				"modelEventType": {
					"id": "wevent:ProofCorrectionsToTypesetter",
					"mnemonic": "PRF CRX to TS"
				},
				"eventCode": "TO_CXUNPAG",
				"dateForecastOriginal": "2020-12-25",
				"dateForecastCurrent": "2020-12-25",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2838",
				"modelEventType": {
					"id": "wevent:PublishedOnlineEarlyUnpaginated",
					"mnemonic": "EV Pub Online"
				},
				"eventCode": "MSWISUNPAG",
				"dateForecastOriginal": "2021-01-05",
				"dateForecastCurrent": "2021-01-05",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2839",
				"modelEventType": {
					"id": "wevent:EarlyViewFileApproved",
					"mnemonic": "EV Files APPR"
				},
				"eventCode": "UNPGSGMLAP",
				"dateForecastOriginal": "2021-01-04",
				"dateForecastCurrent": "2021-01-04",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2840",
				"modelEventType": {
					"id": "wevent:EarlyViewFileReceived",
					"mnemonic": "EV Files RECD"
				},
				"eventCode": "UNPGSGMLLD",
				"dateForecastOriginal": "2020-12-31",
				"dateForecastCurrent": "2020-12-31",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2920",
				"modelEventType": {
					"id": "wevent:BookinComplete",
					"mnemonic": "Bookin Complete"
				},
				"eventCode": "BOOKEDIN",
				"dateForecastOriginal": "2020-12-07",
				"dateForecastCurrent": "2020-12-07",
				"dateCompleted": null
			},
			{
				"modelType": "ScheduleEvent",
				"id": "2922",
				"modelEventType": {
					"id": "wevent:ProofToAuthor",
					"mnemonic": "PRF Out"
				},
				"eventCode": "PRF_OUT",
				"dateForecastOriginal": "2020-12-17",
				"dateForecastCurrent": "2020-12-17",
				"dateCompleted": null
			}
		]
	},
	"authorServicesEnabled": "yes",
	"fundingConfirmedByAuthor": "NA"
}
```

result:
```
[
	{
		"op": "replace",
		"path": "/id",
		"value": "36aae8e6-b399-4e6d-ab6b-508a538d1c76",
		"oldValue": "6f93b1a0-a27b-4767-8ed4-8ad483597eb8"
	},
	{
		"op": "remove",
		"path": "/state",
		"oldValue": "wstate:Created"
	},
	{
		"op": "remove",
		"path": "/created",
		"oldValue": "2020-12-03T13:10:28.957Z"
	},
	{
		"op": "remove",
		"path": "/createdBy",
		"oldValue": {}
	},
	{
		"op": "remove",
		"path": "/modified",
		"oldValue": "2020-12-03T13:11:39.209Z"
	},
	{
		"op": "remove",
		"path": "/modifiedBy",
		"oldValue": {}
	},
	{
		"op": "remove",
		"path": "/appliesLicense/id",
		"oldValue": "4be93b90-2ee1-4e4d-933c-88b69c4d318b"
	},
	{
		"op": "add",
		"path": "/appliesLicense/modelType",
		"value": "CopyrightPolicy"
	},
	{
		"op": "add",
		"path": "/appliesLicense/copyright",
		"value": [
			{
				"htmLang": null,
				"htmValue": null
			}
		]
	},
	{
		"op": "add",
		"path": "/appliesLicense/copyrightPolicyOf",
		"value": {
			"modelType": "CopyrightTransferAgreement",
			"category": null,
			"dateSigned": null
		}
	},
	{
		"op": "add",
		"path": "/appliesLicense/copyrightYear",
		"value": null
	},
	{
		"op": "add",
		"path": "/appliesLicense/distributionModel",
		"value": "Subscription"
	},
	{
		"op": "add",
		"path": "/appliesLicense/license",
		"value": {
			"modelType": null,
			"mnemonic": null
		}
	},
	{
		"op": "replace",
		"path": "/hasWorkMap/id",
		"value": "80da1782-3410-4ba7-a0cc-dcb754712f61",
		"oldValue": "bad8bd79-6de7-4a38-86df-4059d82a6afa"
	},
	{
		"op": "remove",
		"path": "/targetedProduct/state",
		"oldValue": "wstate:Created"
	},
	{
		"op": "replace",
		"path": "/targetedProduct/doi",
		"value": "10.1111/chd.50915",
		"oldValue": "10.1111/chd.50918"
	},
	{
		"op": "replace",
		"path": "/targetedProduct/isPartOfPeriodical/id",
		"value": "6748942",
		"oldValue": "PD6748942"
	},
	{
		"op": "remove",
		"path": "/targetedProduct/productCode",
		"oldValue": "CHD50918"
	},
	{
		"op": "add",
		"path": "/targetedProduct/id",
		"value": "15039392"
	},
	{
		"op": "remove",
		"path": "/usesWorkflow",
		"oldValue": "wwfl:ArticleStandardWorkflow"
	},
	{
		"op": "remove",
		"path": "/cas",
		"oldValue": 1607001099227955200
	},
	{
		"op": "remove",
		"path": "/productionOf",
		"oldValue": {
			"modelType": "Submission",
			"id": "3fd16d37-92b6-4c0d-9be9-59444fcf43f9"
		}
	},
	{
		"op": "remove",
		"path": "/_links",
		"oldValue": {
			"self": {
				"href": "http://cmh-production-api-qa.aws.wiley.com:8080/v1/productions/6f93b1a0-a27b-4767-8ed4-8ad483597eb8"
			}
		}
	},
	{
		"op": "add",
		"path": "/productionContact",
		"value": [
			{
				"modelType": "Participant",
				"id": "e6dcec6d-3734-4580-bb6d-c1edb2497785",
				"givenName": "Oleg",
				"familyName": "Tkachenko",
				"orcId": "0000-0003-0888-1984"
			}
		]
	},
	{
		"op": "add",
		"path": "/requiresPayment",
		"value": [
			{
				"modelType": "Order",
				"paymentDate": null
			}
		]
	},
	{
		"op": "add",
		"path": "/status",
		"value": "BOOKIN"
	},
	{
		"op": "add",
		"path": "/comment",
		"value": [
			null
		]
	},
	{
		"op": "add",
		"path": "/commentProduction",
		"value": [
			"Sanmiguel-Rojas, Enrique:http://orcid.org/0000-0003-0888-1984 add to AQF:missing GTOC"
		]
	},
	{
		"op": "add",
		"path": "/hasSchedule",
		"value": {
			"modelType": "Schedule",
			"id": "288C8545-0AC9-211A-69C5-86BB1B6C3FF8",
			"state": "wstate:Created",
			"hasScheduleEvent": [
				{
					"modelType": "ScheduleEvent",
					"id": "2818",
					"modelEventType": {
						"id": "wevent:IssueCompilation",
						"mnemonic": "Issue Compilation"
					},
					"eventCode": "PRESS",
					"dateForecastOriginal": null,
					"dateForecastCurrent": null,
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2820",
					"modelEventType": {
						"id": "wevent:ProofedByAuthor",
						"mnemonic": "PRF RECD"
					},
					"eventCode": "FR_AU",
					"dateForecastOriginal": "2020-12-22",
					"dateForecastCurrent": "2020-12-22",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2826",
					"modelEventType": {
						"id": "wevent:ManuscriptReceivedInProduction",
						"mnemonic": "RECD at JWS"
					},
					"eventCode": "RECD",
					"dateForecastOriginal": "2020-12-03",
					"dateForecastCurrent": "2020-12-03",
					"dateCompleted": "2020-12-03"
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2832",
					"modelEventType": {
						"id": "wevent:ManuscriptToTypesetter",
						"mnemonic": "To TS"
					},
					"eventCode": "TO_TYPE",
					"dateForecastOriginal": "2020-12-07",
					"dateForecastCurrent": "2020-12-07",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2833",
					"modelEventType": {
						"id": "wevent:RevisedProofApproved",
						"mnemonic": "REV ART PRF APPR"
					},
					"eventCode": "UPGCXPRFAP",
					"dateForecastOriginal": "2020-12-29",
					"dateForecastCurrent": "2020-12-29",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2834",
					"modelEventType": {
						"id": "wevent:RevisedProofReceived",
						"mnemonic": "REV ART PRF RECD"
					},
					"eventCode": "FR_CXUNPAG",
					"dateForecastOriginal": "2020-12-28",
					"dateForecastCurrent": "2020-12-28",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2837",
					"modelEventType": {
						"id": "wevent:ProofCorrectionsToTypesetter",
						"mnemonic": "PRF CRX to TS"
					},
					"eventCode": "TO_CXUNPAG",
					"dateForecastOriginal": "2020-12-25",
					"dateForecastCurrent": "2020-12-25",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2838",
					"modelEventType": {
						"id": "wevent:PublishedOnlineEarlyUnpaginated",
						"mnemonic": "EV Pub Online"
					},
					"eventCode": "MSWISUNPAG",
					"dateForecastOriginal": "2021-01-05",
					"dateForecastCurrent": "2021-01-05",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2839",
					"modelEventType": {
						"id": "wevent:EarlyViewFileApproved",
						"mnemonic": "EV Files APPR"
					},
					"eventCode": "UNPGSGMLAP",
					"dateForecastOriginal": "2021-01-04",
					"dateForecastCurrent": "2021-01-04",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2840",
					"modelEventType": {
						"id": "wevent:EarlyViewFileReceived",
						"mnemonic": "EV Files RECD"
					},
					"eventCode": "UNPGSGMLLD",
					"dateForecastOriginal": "2020-12-31",
					"dateForecastCurrent": "2020-12-31",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2920",
					"modelEventType": {
						"id": "wevent:BookinComplete",
						"mnemonic": "Bookin Complete"
					},
					"eventCode": "BOOKEDIN",
					"dateForecastOriginal": "2020-12-07",
					"dateForecastCurrent": "2020-12-07",
					"dateCompleted": null
				},
				{
					"modelType": "ScheduleEvent",
					"id": "2922",
					"modelEventType": {
						"id": "wevent:ProofToAuthor",
						"mnemonic": "PRF Out"
					},
					"eventCode": "PRF_OUT",
					"dateForecastOriginal": "2020-12-17",
					"dateForecastCurrent": "2020-12-17",
					"dateCompleted": null
				}
			]
		}
	},
	{
		"op": "add",
		"path": "/authorServicesEnabled",
		"value": "yes"
	},
	{
		"op": "add",
		"path": "/fundingConfirmedByAuthor",
		"value": "NA"
	}
]
```
