package com.gc.learning.aws.s3

import awscala._
import s3._

/**
  * Created by ganeshchand on 3/23/17.
  */

object S3Example extends App {

  implicit val s3 = S3()


  // list all buckets
  val buckets = s3.buckets.map(_.name)

  println(s"There are total of ${buckets.size} buckets. Following are the name of the buckets:")
  buckets.foreach(println)

  // find a bucket

  val bucketToFind = "ganesh-s3-bucket"

  val myBucket = s3.bucket(bucketToFind).get

  //  print bucket.objectSummaries
  println(s3.bucket(bucketToFind).get.objectSummaries())


  println(s"getting content of $bucketToFind")

  s3.ls(myBucket, "test12/")
    .map(x => (x.toOption.get.getBucketName, x.toOption.get.getKey))
    .foreach(println)


}
