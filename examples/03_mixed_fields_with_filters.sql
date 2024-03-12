-- select filtered count
select count(t1_0.id)
from transactions t1_0
         join accounts sa1_0 on sa1_0.id = t1_0.sender_id
         join customers c1_0 on c1_0.id = sa1_0.customer_id
where t1_0.amount > ?
  and upper(case when (c1_0.age >= ?) then ? else 'N' end) = ?
  and lower(((c1_0.first_name || ?) || c1_0.last_name)) like ? escape '!' fetch first ? rows only

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
       ((c1_0.first_name || ?) || c1_0.last_name),
       null,
       null,
       null,
       null,
       c1_0.email,
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
from transactions t1_0
         join accounts sa1_0 on sa1_0.id = t1_0.sender_id
         join customers c1_0 on c1_0.id = sa1_0.customer_id
where t1_0.amount > ?
  and upper(case when (c1_0.age >= ?) then ? else 'N' end) = ?
  and lower(((c1_0.first_name || ?) || c1_0.last_name)) like ? escape '!' fetch first ? rows only