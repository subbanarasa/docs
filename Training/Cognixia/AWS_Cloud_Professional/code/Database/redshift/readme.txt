https://docs.aws.amazon.com/redshift/latest/gsg/rs-gsg-launch-sample-cluster.html

awsuser/Awsuser1234

1. Create role with AWS Service redshift --  use case, choose Redshift - Customizable
2. Attach permissions policies page, choose AmazonS3ReadOnlyAccess.
3. copy arn:aws:iam::266536961422:role/myRedshiftRole
4. 
copy users from 's3://awsprofdemo/tickitdb/allusers_pipe.txt' 
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole' 
delimiter '|' region 'ap-south-1';

copy venue from 's3://awsprofdemo/tickitdb/venue_pipe.txt' 
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole' 
delimiter '|' region 'ap-south-1';

copy category from 's3://awsprofdemo/tickitdb/category_pipe.txt' 
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole' 
delimiter '|' region 'ap-south-1';

copy date from 's3://awsprofdemo/tickitdb/date2008_pipe.txt' 
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole' 
delimiter '|' region 'ap-south-1';

copy event from 's3://awsprofdemo/tickitdb/allevents_pipe.txt' 
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole' 
delimiter '|' timeformat 'YYYY-MM-DD HH:MI:SS' region 'ap-south-1';

copy listing from 's3://awsprofdemo/tickitdb/listings_pipe.txt' 
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole' 
delimiter '|' region 'ap-south-1';

copy sales from 's3://awsprofdemo/tickitdb/sales_tab.txt'
credentials 'aws_iam_role=arn:aws:iam::266536961422:role/myRedshiftRole'
delimiter '\t' timeformat 'MM/DD/YYYY HH:MI:SS' region 'ap-south-1';


-- Get definition for the sales table.
SELECT *    
FROM pg_table_def    
WHERE tablename = 'sales';    

-- Find total sales on a given calendar date.
SELECT sum(qtysold) 
FROM   sales, date 
WHERE  sales.dateid = date.dateid 
AND    caldate = '2008-01-05';

-- Find top 10 buyers by quantity.
SELECT firstname, lastname, total_quantity 
FROM   (SELECT buyerid, sum(qtysold) total_quantity
        FROM  sales
        GROUP BY buyerid
        ORDER BY total_quantity desc limit 10) Q, users
WHERE Q.buyerid = userid
ORDER BY Q.total_quantity desc;

-- Find events in the 99.9 percentile in terms of all time gross sales.
SELECT eventname, total_price 
FROM  (SELECT eventid, total_price, ntile(1000) over(order by total_price desc) as percentile 
       FROM (SELECT eventid, sum(pricepaid) total_price
             FROM   sales
             GROUP BY eventid)) Q, event E
       WHERE Q.eventid = E.eventid
       AND percentile = 1
ORDER BY total_price desc;


