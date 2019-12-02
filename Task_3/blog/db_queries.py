from django.db import connection
import django
import os


class DbQuery:

    def __init__(self):
        os.environ.setdefault("DJANGO_SETTINGS_MODULE", "Task_3.settings")
        django.setup()
        self.cursor = connection.cursor()

    def query_1(self):
        sql = "SELECT * FROM blog_post;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_2(self):
        sql = "SELECT id, title, created_date FROM blog_post;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_3(self):
        sql = "SELECT DISTINCT author_id FROM blog_post;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_4(self):
        sql = "SELECT * FROM blog_post WHERE (id<4 OR id >18) AND author_id=1;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_5(self):
        sql = "SELECT * FROM blog_post ORDER BY created_date DESC;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_6(self):
        sql = "INSERT INTO blog_post ('title', 'text', 'author_id', 'created_date')" \
              "VALUES ('new post', 'Nice new post from code', 1, (SELECT datetime('now')));"
        self.cursor.execute(sql)
        print(sql)

    def query_7(self):
        sql = "SELECT * FROM blog_post WHERE created_date IS NOT NULL;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_8(self):
        sql = "UPDATE blog_post SET published_date=(SELECT datetime('now')) WHERE id<20;"
        self.cursor.execute(sql)
        print(sql)

    def query_9(self):
        sql = "DELETE FROM blog_post WHERE id > 25;"
        self.cursor.execute(sql)
        print(sql)

    def query_10(self):
        sql = "SELECT * FROM blog_post ORDER BY id DESC LIMIT 1;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_11(self):
        sql = "SELECT COUNT(*) FROM blog_post;"
        self.cursor.execute(sql)
        rows = self.cursor.fetchall()
        print(sql)
        print(rows)

    def query_12(self):
        sql = "SELECT text FROM blog_post WHERE title LIKE 'T%';"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_13(self):
        sql = "SELECT * FROM blog_post WHERE title in ('Made in console', 'Test Post');"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_14(self):
        sql = "SELECT created_date AS Created FROM blog_post;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_15(self):
        sql = "SELECT blog_post.text, auth_user.id FROM blog_post INNER JOIN auth_user ON blog_post.author_id = auth_user.id;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_16(self):
        sql = "SELECT blog_post.text, auth_user.id FROM blog_post LEFT JOIN auth_user ON blog_post.author_id = auth_user.id;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_17(self):
        sql = "SELECT * from blog_post GROUP BY author_id;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_18(self):
        sql = "SELECT * from blog_post GROUP BY author_id HAVING id>5 ORDER BY created_date;"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    def query_19(self):
        sql = "SELECT * from blog_post WHERE EXISTS (SELECT * FROM auth_user);"
        self.cursor.execute(sql)
        columns = [col[0] for col in self.cursor.description]
        rows = self.cursor.fetchall()
        print(sql)
        print(columns)
        for p in rows:
            print(p)

    # def query20(self):
    #     sql = "SELECT * INTO blog_new_post FROM blog_post;"
    #     self.cursor.execute(sql)
    #     columns = [col[0] for col in self.cursor.description]
    #     rows = self.cursor.fetchall()
    #     print(sql)
    #     print(columns)
    #     for p in rows:
    #         print(p)

    # def query21(self):
    #     sql = "INSERT INTO blog_new_post2 SELECT * FROM blog_post WHERE id < 10;"
    #     self.cursor.execute(sql)
    #     columns = [col[0] for col in self.cursor.description]
    #     rows = self.cursor.fetchall()
    #     print(sql)
    #     print(columns)
    #     for p in rows:
    #         print(p)


db = DbQuery()
attrs = (getattr(db, name) for name in dir(db))

counter = 1
for method in attrs:
    if 'query' in str(method):
        print(str(counter) + ". ========================================================")
        print(method)
        method()
        counter += 1
