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
       sa1_0.account_number,
       sa1_0.currency,
       sa1_0.card_number,
       sa1_0.card_type,
       ((c1_0.first_name || ?) || c1_0.last_name),
       c1_0.first_name,
       c1_0.last_name,
       c1_0.age,
       case when (c1_0.age >= ?) then cast(? as varchar) else 'N' end,
       c1_0.email,
       c1_0.country,
       c1_0.postal_code,
       c1_0.phone_number,
       ra1_0.account_number,
       ra1_0.currency,
       ra1_0.card_number,
       ra1_0.card_type,
       ((c2_0.first_name || ?) || c2_0.last_name),
       c2_0.first_name,
       c2_0.last_name,
       c2_0.age,
       case when (c2_0.age >= ?) then cast(? as varchar) else 'N' end,
       c2_0.email,
       c2_0.country,
       c2_0.postal_code,
       c2_0.phone_number
from transactions t1_0
         join accounts sa1_0 on sa1_0.id = t1_0.sender_id
         join customers c1_0 on c1_0.id = sa1_0.customer_id
         join accounts ra1_0 on ra1_0.id = t1_0.recipient_id
         join customers c2_0 on c2_0.id = ra1_0.customer_id fetch first ? rows only