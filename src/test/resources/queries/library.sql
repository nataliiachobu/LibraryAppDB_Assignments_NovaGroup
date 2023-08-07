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