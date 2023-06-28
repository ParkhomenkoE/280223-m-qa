-- Наполнить произвольными данными таблицы streams, reactions, donations
INSERT INTO donations (donation_id, created_at, amount, donator_id, stream_id)
 VALUES
	(1, current_timestamp, 2100.00, 1, 1 ),
    (2, current_timestamp, 5200.00, 2, 2 ),
    (3, current_timestamp, 210.00, 3, 2 ),
    (4, current_timestamp, 1000.00, 3, 3 ),
    (5, current_timestamp, 21800.00, 4, 4 );
    
INSERT INTO reactions (reaction_id, created_at, author_id, stream_id, `value`)
values
	(1, current_timestamp, 1, 1, 10 ),
    (2, current_timestamp, 2, 2, 21 ),
    (3, current_timestamp, 3, 3, 111 ),
    (4, current_timestamp, 4, 4, 15 ),
    (5, current_timestamp, 5, 5, 212 );
    
INSERT INTO streams (stream_id, created_at, author_id, title, is_completed)
values
	(1, current_timestamp, 1, 100, false ),
    (2, current_timestamp, 2, 210, false ),
    (3, current_timestamp, 3, 111, false ),
    (4, current_timestamp, 4, 301, false ),
    (5, current_timestamp, 5, 5015, false );

-- Вывести информацию по стримам (проекция: имяавтора, названиестрима)   
SELECT username,
  title
FROM streams 
  LEFT JOIN users ON streams.author_id = users.user_id;
  
-- Вывести список пожертвований в порядке убывания размера 
-- (проекция: размерпожертвования, имядонатара, название_стрима)  
SELECT streams.title,
  users.username,
  donations.amount
FROM donations 
  LEFT JOIN users  ON donations.donation_id = users.user_id
  LEFT JOIN streams on streams.stream_id = donations.stream_id
  order by amount desc;

  
