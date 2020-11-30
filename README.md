# json-diff-with-old-value

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
		"oldValue": "\"deleted\""
	},
	{
		"op": "replace",
		"path": "/e",
		"value": "new",
		"oldValue": "\"old\""
	},
	{
		"op": "add",
		"path": "/c",
		"value": "123"
	}
]
```
