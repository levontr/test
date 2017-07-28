val sqlContext = new org.apache.spark.sql.SQLContext(sc)
val pbusiness = sqlContext.read.parquet("/output/yelp_academic_dataset_business.parquet")
pbusiness.registerTempTable("business")
val preview = sqlContext.read.parquet("/output/yelp_academic_dataset_review.parquet")
preview.registerTempTable("review")
val allrecords = sqlContext.sql("select b.state, b.city, count(*) totalreviews from business b group by b.state, b.city order by totalreviews desc").limit(50)
allrecords.show(50)
