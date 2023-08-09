select *
from books;

select count(id)
from users; -- actual

select count(distinct id)
from users; -- expected

select *
from book_categories;

select *
from book_borrow;

select *
from books;
select * from book_categories;

select book_categories.name, count(*) from book_categories join books b on book_categories.id = b.book_category_id group by book_category_id
having count(*) = (select max(book_count)
                   from (select count(*) as book_count from books group by book_category_id)as counts);

#us02
select count(*) from book_borrow
where is_returned=0;

#us03
select name from book_categories;

#US06
select name from books
where name = 'Jane Doe';

select bc.name, count(bb.id)
from book_borrow bb
         join books b on bb.book_id = b.id
         join book_categories bc on bc.id = b.book_category_id
group by bc.name order by count(bb.id) desc;
