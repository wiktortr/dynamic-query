-- select filtered count
select count(t1_0.id)
from transactions t1_0 fetch first ? rows only

-- select records
select t1_0.id,
       t1_0.amount,
       t1_0.fee,
       t1_0.address,
       t1_0.country,
       t1_0.approval_status,
       t1_0.approval_date,
       t1_0.transaction_date,
       t1_0.status,
       t1_0.category,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null,
       null
from transactions t1_0 fetch first ? rows only