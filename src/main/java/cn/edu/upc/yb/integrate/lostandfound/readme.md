### LostAndFound接口

|url            | 详情     |  方法 | 参数 |返回值| 
|------|------|---|---|---|
| /lostandfound/       | 返回所有存在的物品    | get | 无 | 好多条数据 |
| /lostandfound/details/  | 一个物品的细节     | get | id ,type |  一条数据 |
| /lostandfound/showall/  | 返回所有的物品     | get | 无 |  好多条数据 |
| /lostandfound/publish/  | 发布信息           | post | title,details,what | 发布成功或没有登陆 |
| /lostandfound/finduser/ | 返回找失主的信息   | get | 无 | 好多条数据 | 
| /lostandfound/findthing/ | 返回找物品的信息  | get | 无 | 好多条数据 |
| /lostandfound/official/  | 管理员添加数据库  | post | title,detail | 添加成功或没有登陆或没有权限 |
| /lostandfound/delete     |  删除某条数据    | post | id ,type | 删除成功或没有登陆或没有权限 |
| /lostandfound/changestatus  | 改变状态      | post | id | 更改成功或没有登陆或没有权限 |
             