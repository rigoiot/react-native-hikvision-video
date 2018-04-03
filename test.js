var Minio = require('minio');

var minioClient = new Minio.Client({
  endPoint: 'host3.iadyun.com',
  port: 9000,
  secure: false,
  accessKey: '65ZWIYc3UZWpyUjkzanFt5Ie1sBB7sjf',
  secretKey: 'JwT4gOiKV49c90mqQY7GIxCuxn'
});
var file = './App.js';

// console.log(minioClient);

minioClient.listBuckets(function(err, buckets) {
  if (err) return console.log('listBuckets', err);
  console.log('buckets :', buckets);
});

// minioClient.makeBucket('cat', 'us-east-1', function(err) {
//   if (err) return console.log('err1:', err);
//
//   console.log('created successfully');
//
//   // Using fPutObject API upload your file to the bucket europetrip.
//   minioClient.fPutObject('smyy', 'App.js', file, 'application/octet-stream', function(err, etag) {
//     if (err) return console.log('err2:', err);
//     console.log('File uploaded successfully.');
//   });
// });
