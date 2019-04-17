# levineye.github.io

阿里云上传图片的两种方式：
1.STS鉴权模式 - 使用阿里云封装的SDK调用，安全简单(https://www.jianshu.com/p/dcc13b4ef905)。\n
2.Policy鉴权模式 - 自己实现模拟表单提交Policy的方式上传文件到阿里云，相对1来说会麻烦一些。

示例的代码段使用了方式2上传图片阿里云。
流程如下：
1.请求服务器，获取Policy相关信息并保存到本地。
2.上传图片之间先检查是否有获取有效Policy。若没有重新执行1，若有则往下执行。
2.通过模拟表单提交的方式上传图片到阿里云。
3.接收到返回信息为200或204时，证明上传文件以及成功。服务器不会在流中返回文件的url，需要自己做拼接。
5.已上传图片的拼接规则 --> host + dir + fileName(上传文件的名称)

服务器返回的Json格式Policy信息示例
{
    “data”: {
        “OSSAccessKeyId”: “TTTItPhBbakTH3JP”,//必须字段
        “host”: “https://xxxxxxxxxxx.oss-cn-hangzhou.aliyuncs.com”, // 必须字段，上传文件url，xxxxxxxxxxx即bucket name，阿里云定于云存储的仓库名称
        “dir”: “201903/9B4919085ADA4C169B431DBAC8A84218/”, // 必须字段，文件保存目录
        “policy”: “eyJleHBpcmF0aW9uIjoiMjAxOS0wMy0xMlQwOTowODoxMS43NzlaIiwiY29uZGl0aW9ucyI6W1siY29udGVudC1sZW5ndGgtcmFuZ2UiLDAsMTA0ODU3NjAwMF0sWyJzdGFydHMtd2l0aCIsIiRrZXkiLCIyMDE5MDMvOUI0OTE5MDg1QURBNEMxNjlCNDMxREJBQzhBODQyMTgvIl1dfQ==”, // 必须字段，Policy信息
        “Signature”: “qZQjW0xEoSABv9wb1VhxFjuuCuI=”, // 必须字段，签名信息
        “expire”: “1552381691” // 非必须字段，过期时间，该字段是服务器确定的
    }
}
