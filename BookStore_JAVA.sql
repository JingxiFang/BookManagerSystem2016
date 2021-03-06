USE [master]
GO
/****** Object:  Database [BookStore_JAVA]    Script Date: 2016.12.17 16:41:02 ******/
CREATE DATABASE [BookStore_JAVA]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'BookStore_JAVA', FILENAME = N'E:\小组\小组练习文件夹\练习\数据库\BookStore_JAVA_data.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'BookStore_JAVA_log', FILENAME = N'E:\小组\小组练习文件夹\练习\数据库\BookStore_JAVA_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [BookStore_JAVA] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BookStore_JAVA].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BookStore_JAVA] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET ARITHABORT OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [BookStore_JAVA] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BookStore_JAVA] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BookStore_JAVA] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET  DISABLE_BROKER 
GO
ALTER DATABASE [BookStore_JAVA] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BookStore_JAVA] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET RECOVERY FULL 
GO
ALTER DATABASE [BookStore_JAVA] SET  MULTI_USER 
GO
ALTER DATABASE [BookStore_JAVA] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BookStore_JAVA] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BookStore_JAVA] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BookStore_JAVA] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'BookStore_JAVA', N'ON'
GO
USE [BookStore_JAVA]
GO
/****** Object:  StoredProcedure [dbo].[SelectBorrowByBookID]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SelectBorrowByBookID]
@bookId  int
as
begin

select rbs.id as borrowId, Reader.readerName,Reader.readerId,rbs.starDay,Status.statusName from Book 
inner join Reader_Book_Status rbs 
on rbs.bookId=Book.Id
inner join Reader 
on Reader.readerId=rbs.readerId
inner join Status
on Status.statusId=rbs.statusId
where Book.Id=@bookId
end

GO
/****** Object:  StoredProcedure [dbo].[SelectBorrowByReaderID]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SelectBorrowByReaderID]
@readerId  int
as
begin

select rbs.id as borrowId, Book.Id,Book.bookName,rbs.starDay,Status.statusName from Book 
inner join Reader_Book_Status rbs 
on rbs.bookId=Book.Id
inner join Reader 
on Reader.readerId=rbs.readerId
inner join Status
on Status.statusId=rbs.statusId
where Reader.readerId=  @readerId
end
GO
/****** Object:  StoredProcedure [dbo].[SelectReaderBorrowBook]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[SelectReaderBorrowBook] 
@staticid  int,
@readerId  int
as
begin

select book.Id,Book.bookName,rbs.starDay,rbs.id from Book 
inner join Reader_Book_Status rbs 
on rbs.bookId=Book.Id
inner join Reader 
on Reader.readerId=rbs.readerId
inner join Status
on Status.statusId=rbs.statusId
where Reader.readerId=@readerId and rbs.statusId=@staticid
end

GO
/****** Object:  StoredProcedure [dbo].[SelectReaderDaysAndHirele]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[SelectReaderDaysAndHirele]
@borrowId int
as
begin
select  datediff(day,starDay,endDay)as days , bt.typeStartHireRule,bt.typeEndHireRule , rt.typePrivilege from Reader_Book_Status rbs
inner join Book bk 
on bk.Id= rbs.bookId
inner join BookType bt
on  bt.typeid=bk.bookType
inner join Reader rd
on rbs.readerId= rd.readerId
inner join ReaderType rt
on rt.typeId=rd.readerType
where rbs.id=  @borrowId
end
GO
/****** Object:  Table [dbo].[Book]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Book](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[bookType] [int] NOT NULL,
	[bookName] [nvarchar](100) NOT NULL,
	[bookPrice] [decimal](5, 2) NOT NULL,
	[bookConcern] [nvarchar](100) NULL,
	[bookAuthor] [nvarchar](50) NULL,
	[bookTotality] [int] NOT NULL,
	[bookCurInv] [int] NOT NULL,
	[Describe] [nvarchar](400) NULL,
	[flag] [int] NOT NULL,
 CONSTRAINT [PK_Book] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[BookType]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BookType](
	[typeid] [int] IDENTITY(1,1) NOT NULL,
	[typename] [nvarchar](50) NOT NULL,
	[typeStartHireRule] [decimal](5, 2) NOT NULL,
	[typeEndHireRule] [decimal](5, 2) NOT NULL,
	[flag] [int] NOT NULL,
 CONSTRAINT [PK_BookType] PRIMARY KEY CLUSTERED 
(
	[typeid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[managerId] [int] IDENTITY(1,1) NOT NULL,
	[managerName] [nvarchar](20) NOT NULL,
	[managerPwd] [nvarchar](20) NOT NULL,
	[managerState] [int] NOT NULL,
	[flag] [int] NULL,
 CONSTRAINT [PK_User_1] PRIMARY KEY CLUSTERED 
(
	[managerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Reader]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reader](
	[readerId] [int] IDENTITY(1,1) NOT NULL,
	[readerName] [nvarchar](50) NOT NULL,
	[readerType] [int] NOT NULL,
	[readerPhone] [nvarchar](12) NOT NULL,
	[readerAdderess] [nvarchar](50) NULL,
	[ResigterTime] [datetime] NOT NULL,
	[flag] [int] NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[readerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Reader_Book_Status]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reader_Book_Status](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[readerId] [int] NOT NULL,
	[bookId] [int] NOT NULL,
	[statusId] [int] NOT NULL,
	[starDay] [datetime] NOT NULL,
	[endDay] [datetime] NULL,
 CONSTRAINT [PK_User_Book_Status] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ReaderType]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReaderType](
	[typeId] [int] IDENTITY(1,1) NOT NULL,
	[typeName] [nvarchar](50) NOT NULL,
	[typePrivilege] [decimal](3, 2) NULL,
 CONSTRAINT [PK_UserType] PRIMARY KEY CLUSTERED 
(
	[typeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Status]    Script Date: 2016.12.17 16:41:02 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Status](
	[statusId] [int] IDENTITY(1,1) NOT NULL,
	[statusName] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Status] PRIMARY KEY CLUSTERED 
(
	[statusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Book] ON 

INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (1, 1, N'走在有光的路上', CAST(19.50 AS Decimal(5, 2)), N'中国友谊出版公司', N'王义博', 15, 13, NULL, 0)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (2, 1, N'我不过低配的人生', CAST(19.50 AS Decimal(5, 2)), N'雾满拦江', N'中国友谊出版公司', 15, 15, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (3, 3, N'愿人生从容', CAST(36.30 AS Decimal(5, 2)), N'九州出版社', N'贾平凹', 5, 15, N'rehher', 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (4, 1, N'上海堡垒', CAST(18.60 AS Decimal(5, 2)), N'江南', N'长江出版社', 15, 15, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (6, 4, N'我的世界都是你', CAST(27.00 AS Decimal(5, 2)), N'几米', N'现代出版社', 9, 9, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (7, 4, N'好吗好的', CAST(19.10 AS Decimal(5, 2)), N'大冰', N'湖南文艺出版社', 20, 20, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (8, 3, N'第一行代码Android第二版', CAST(62.40 AS Decimal(5, 2)), N'郭霖', N'人民邮电出版社', 15, 15, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (9, 3, N'Phthon', CAST(53.00 AS Decimal(5, 2)), N'（挪）Magnus Lie Hetland', N'人民邮电出版社', 15, 15, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (10, 3, N'Java从入门到精通（第三版）', CAST(29.30 AS Decimal(5, 2)), N'明日科技', N'清华大学出版社', 10, 10, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (11, 3, N'人月神话', CAST(33.30 AS Decimal(5, 2)), N'布鲁克斯', N'清华大学出版社', 5, 5, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (12, 3, N'失控', CAST(43.60 AS Decimal(5, 2)), N'凯文凯利', N'电子工业出版社', 5, 5, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (13, 3, N'必然', CAST(59.00 AS Decimal(5, 2)), N'凯文凯利', N'电子工业出版社', 5, 5, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (14, 3, N'科技想要什么', CAST(28.40 AS Decimal(5, 2)), N'凯文凯利', N'电子工业出版社', 5, 5, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (18, 1, N'我的孤独是一座花园', CAST(19.60 AS Decimal(5, 2)), N'[叙利亚] 阿多尼斯', N'译林出版社', 10, 10, NULL, 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (19, 1, N'心静的力量', CAST(13.40 AS Decimal(5, 2)), N'北京联合出版公司', N'拿破仑·希尔', 5, 5, N'《心静的力量》是成功学鼻祖拿破仑·希尔博士在84岁高龄写下的收官之作，他筹备了70余年时间，拜访了500多位美国成功人士，收集、整理、分析成功哲学之大成。

    针对现代人面临的日益加剧的恐惧与困顿，希尔博士开始反思自己的心路历程，梳理之前的研究成果，并探究罗斯福、爱迪生、福特、洛克菲勒等人的成功轨迹。

    他提出了“心静”的概念，总结出16大心静方法论，强调坚持自我的重要性，也给出了非常具体的行动方案，促使每一位读者由心而始，让人生发生美好的改变！', 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (20, 4, N'小妇人', CAST(15.60 AS Decimal(5, 2)), N'天地出版社', N'(美)路易莎·奥尔科特', 10, 10, N'本书为美国作家路易莎·奥尔科特根据对自己孩提时的回忆写成的传世之作，讲述了马奇一家四姐妹对自我梦想的追求及其对家庭的眷恋。父亲从军之后，四姐妹相亲相爱，像天使一样用自己的执著、乐趣装点着各自的理想。生活尽管清贫，但并没有阻止她们追求幸福和快乐的脚步。冷静细心的作者用细腻的笔触书写了所有少女成长过程中都难以回避的人生经历；初恋的甜蜜和烦恼，理想和现实的差距等。本书给我们的启示是：在女孩成长的道路上，大人们应学会理解、宽容，引导她们健康成长。 ', 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (21, 3, N'Head First C#（第三版） ', CAST(111.00 AS Decimal(5, 2)), N'中国电力出版社', N'（美）施特尔曼，（美）格林', 10, 10, N'《Head First C#（第三版）》《Head First C#（第三版）》是学习使用C#、XAML、.NET Framework和Visual Studio编程的jue佳途径，会让你有全新的学习体验。这专门针对你的大脑特别制作，从第1章开始就会把你牢牢吸引住，你会在第1章中构建一个功能完备的视频游戏。接下来，你会学习类和面向对象编程、绘制图形和动画、用LINQ查询数据，还可以串行化到文件。所有这些都是通过构建游戏、解决谜题和动手建立工程获得的。学完所有这些内容之后，你将成为一个高水平的C#程序员，而且这将是一个轻松愉悦的学习过程！', 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (22, 1, N'我只能送你一张小卡片', CAST(15.00 AS Decimal(5, 2)), N'长江出版社', N'几米', 6, 6, N'', 1)
INSERT [dbo].[Book] ([Id], [bookType], [bookName], [bookPrice], [bookConcern], [bookAuthor], [bookTotality], [bookCurInv], [Describe], [flag]) VALUES (23, 4, N'星空', CAST(65.10 AS Decimal(5, 2)), N'长江出版社', N'几米', 2, 2, N'', 1)
SET IDENTITY_INSERT [dbo].[Book] OFF
SET IDENTITY_INSERT [dbo].[BookType] ON 

INSERT [dbo].[BookType] ([typeid], [typename], [typeStartHireRule], [typeEndHireRule], [flag]) VALUES (1, N'普通图书', CAST(1.00 AS Decimal(5, 2)), CAST(1.00 AS Decimal(5, 2)), 1)
INSERT [dbo].[BookType] ([typeid], [typename], [typeStartHireRule], [typeEndHireRule], [flag]) VALUES (3, N'计算机图书', CAST(1.50 AS Decimal(5, 2)), CAST(1.50 AS Decimal(5, 2)), 1)
INSERT [dbo].[BookType] ([typeid], [typename], [typeStartHireRule], [typeEndHireRule], [flag]) VALUES (4, N'新书', CAST(1.50 AS Decimal(5, 2)), CAST(2.00 AS Decimal(5, 2)), 1)
INSERT [dbo].[BookType] ([typeid], [typename], [typeStartHireRule], [typeEndHireRule], [flag]) VALUES (5, N'校园文学', CAST(0.80 AS Decimal(5, 2)), CAST(1.00 AS Decimal(5, 2)), 0)
INSERT [dbo].[BookType] ([typeid], [typename], [typeStartHireRule], [typeEndHireRule], [flag]) VALUES (6, N'会计用书', CAST(1.50 AS Decimal(5, 2)), CAST(2.00 AS Decimal(5, 2)), 1)
SET IDENTITY_INSERT [dbo].[BookType] OFF
SET IDENTITY_INSERT [dbo].[Manager] ON 

INSERT [dbo].[Manager] ([managerId], [managerName], [managerPwd], [managerState], [flag]) VALUES (2, N'xiaoming', N'xiaoming', 1, 1)
INSERT [dbo].[Manager] ([managerId], [managerName], [managerPwd], [managerState], [flag]) VALUES (3, N'xiaohong', N'xiaohong', 0, 1)
INSERT [dbo].[Manager] ([managerId], [managerName], [managerPwd], [managerState], [flag]) VALUES (4, N'123', N'123', 0, 0)
INSERT [dbo].[Manager] ([managerId], [managerName], [managerPwd], [managerState], [flag]) VALUES (5, N'123456', N'123456', 0, 1)
INSERT [dbo].[Manager] ([managerId], [managerName], [managerPwd], [managerState], [flag]) VALUES (6, N'xiaoli', N'xiaoli', 0, 0)
SET IDENTITY_INSERT [dbo].[Manager] OFF
SET IDENTITY_INSERT [dbo].[Reader] ON 

INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1, N'黄明', 2, N'17854263246', NULL, CAST(0x0000A6DD007B8F68 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (2, N'梨花', 2, N'12345678945', NULL, CAST(0x0000A6DE00B3EF59 AS DateTime), 0)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (3, N'王洪', 3, N'12345617831', NULL, CAST(0x0000A6DE012634A3 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (4, N'王洪', 3, N'12345617831', NULL, CAST(0x0000A6DE01263897 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (5, N'李鸿谷', 3, N'12354682131', NULL, CAST(0x0000A6DE01266CA8 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (6, N'李鸿谷', 3, N'12354682131', NULL, CAST(0x0000A6DE012698E2 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1003, N'王力宏', 2, N'14523652365', NULL, CAST(0x0000A6DE01434CB9 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1004, N'杨幂', 3, N'17821453154', NULL, CAST(0x0000A6DE0143B822 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1005, N'王力宏', 2, N'14523652365', NULL, CAST(0x0000A6DE0146F9FC AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1006, N'李师师', 3, N'14523677895', NULL, CAST(0x0000A6DE014934AD AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1007, N'达瑞尔斯', 3, N'12345678945', NULL, CAST(0x0000A6DE014996A4 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1008, N'土豪', 1, N'14253678945', NULL, CAST(0x0000A6DE0149F9D0 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1009, N'杨幂', 3, N'17821453154', NULL, CAST(0x0000A6DE014A23FF AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1010, N'法国德国', 1, N'2345', NULL, CAST(0x0000A6DE014AA6B6 AS DateTime), 1)
INSERT [dbo].[Reader] ([readerId], [readerName], [readerType], [readerPhone], [readerAdderess], [ResigterTime], [flag]) VALUES (1011, N'1425', 1, N'1425', NULL, CAST(0x0000A6DE0150B009 AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[Reader] OFF
SET IDENTITY_INSERT [dbo].[Reader_Book_Status] ON 

INSERT [dbo].[Reader_Book_Status] ([id], [readerId], [bookId], [statusId], [starDay], [endDay]) VALUES (2, 1, 1, 2, CAST(0x0000A60F00000000 AS DateTime), CAST(0x0000A61800000000 AS DateTime))
INSERT [dbo].[Reader_Book_Status] ([id], [readerId], [bookId], [statusId], [starDay], [endDay]) VALUES (3, 1, 1, 1, CAST(0x0000A6DB00B28493 AS DateTime), CAST(0x0000A6DD00000000 AS DateTime))
INSERT [dbo].[Reader_Book_Status] ([id], [readerId], [bookId], [statusId], [starDay], [endDay]) VALUES (6, 1, 3, 1, CAST(0x0000A6DD00B68864 AS DateTime), CAST(0x0000A6DE00000000 AS DateTime))
SET IDENTITY_INSERT [dbo].[Reader_Book_Status] OFF
SET IDENTITY_INSERT [dbo].[ReaderType] ON 

INSERT [dbo].[ReaderType] ([typeId], [typeName], [typePrivilege]) VALUES (1, N'普通', CAST(1.00 AS Decimal(3, 2)))
INSERT [dbo].[ReaderType] ([typeId], [typeName], [typePrivilege]) VALUES (2, N'会员', CAST(0.90 AS Decimal(3, 2)))
INSERT [dbo].[ReaderType] ([typeId], [typeName], [typePrivilege]) VALUES (3, N'黄金会员', CAST(0.75 AS Decimal(3, 2)))
INSERT [dbo].[ReaderType] ([typeId], [typeName], [typePrivilege]) VALUES (4, N'vip', CAST(1.00 AS Decimal(3, 2)))
INSERT [dbo].[ReaderType] ([typeId], [typeName], [typePrivilege]) VALUES (5, N'vip', CAST(1.00 AS Decimal(3, 2)))
INSERT [dbo].[ReaderType] ([typeId], [typeName], [typePrivilege]) VALUES (6, N'vip', CAST(1.00 AS Decimal(3, 2)))
SET IDENTITY_INSERT [dbo].[ReaderType] OFF
SET IDENTITY_INSERT [dbo].[Status] ON 

INSERT [dbo].[Status] ([statusId], [statusName]) VALUES (1, N'借阅中       ')
INSERT [dbo].[Status] ([statusId], [statusName]) VALUES (2, N'已归还       ')
INSERT [dbo].[Status] ([statusId], [statusName]) VALUES (3, N'丢失未赔偿     ')
INSERT [dbo].[Status] ([statusId], [statusName]) VALUES (4, N'丢失已赔偿     ')
SET IDENTITY_INSERT [dbo].[Status] OFF
ALTER TABLE [dbo].[Book]  WITH CHECK ADD  CONSTRAINT [FK_Book_Type] FOREIGN KEY([bookType])
REFERENCES [dbo].[BookType] ([typeid])
GO
ALTER TABLE [dbo].[Book] CHECK CONSTRAINT [FK_Book_Type]
GO
ALTER TABLE [dbo].[Reader]  WITH CHECK ADD  CONSTRAINT [FK_User_Type] FOREIGN KEY([readerType])
REFERENCES [dbo].[ReaderType] ([typeId])
GO
ALTER TABLE [dbo].[Reader] CHECK CONSTRAINT [FK_User_Type]
GO
ALTER TABLE [dbo].[Reader_Book_Status]  WITH CHECK ADD  CONSTRAINT [FK_UBS_Book] FOREIGN KEY([bookId])
REFERENCES [dbo].[Book] ([Id])
GO
ALTER TABLE [dbo].[Reader_Book_Status] CHECK CONSTRAINT [FK_UBS_Book]
GO
ALTER TABLE [dbo].[Reader_Book_Status]  WITH CHECK ADD  CONSTRAINT [FK_UBS_Status] FOREIGN KEY([statusId])
REFERENCES [dbo].[Status] ([statusId])
GO
ALTER TABLE [dbo].[Reader_Book_Status] CHECK CONSTRAINT [FK_UBS_Status]
GO
ALTER TABLE [dbo].[Reader_Book_Status]  WITH CHECK ADD  CONSTRAINT [FK_UBS_User] FOREIGN KEY([readerId])
REFERENCES [dbo].[Reader] ([readerId])
GO
ALTER TABLE [dbo].[Reader_Book_Status] CHECK CONSTRAINT [FK_UBS_User]
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'图书与图书类别' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'Book', @level2type=N'CONSTRAINT',@level2name=N'FK_Book_Type'
GO
USE [master]
GO
ALTER DATABASE [BookStore_JAVA] SET  READ_WRITE 
GO
