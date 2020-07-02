SQL> CREATE TABLESPACE tiketbioskop
  2  DATAFILE 'D:\Program\DataBase\
tiketbioskop.dbf'
  3  size 30M;

Tablespace created.

SQL> CREATE USER RizalAdi07040
  2  IDENTIFIED BY rizal
  3  DEFAULT TABLESPACE tiketbioskop
  4  QUOTA 30M ON tiketbioskop;

SQL> create table Pembeli_07040
  2  (
  3  Id_pembeli 		INTEGER not null,
  4  Nama_pembeli	 VARCHAR(20),
  5  Umur			 VARCHAR(10),
  6  Alamat		VARCHAR(100),
  7  Jenis_kelamin	VARCHAR(10),
  8  constraint PK_pembeli primary key (Id_pembeli)
  9  );

Table created.

SQL> create table Pembelian_07040
  2  (
  3  Kode_tiket 		INTEGER not null,
  4  Id_pembeli		INTEGER,
  5  Judul_film		VARCHAR(14),
  6  NO_kursi		NUMBER(5),
  7  Jam_tayang		VARCHAR(15),
  8  Harga_tiket		NUMBER(10),
  9  constraint PK_pembelian primary key (Kode_tiket),
  10 constraint FK_pembeli FOREIGN KEY (Id_pembeli)
  11 REFERENCES Pembeli_07040 (Id_pembeli)
  12 );

Table created.

SQL> create table Transaksi_07040
  2  (
  3  Id_transaksi INTEGER not null,
  4  Id_pembeli INTEGER,
  5  Id_pembelian INTEGER,
  6  Tgl_transaksi DATE,
  7  Harga_total NUMBER(15),
  8  Bayar NUMBER(15),
  9  Kembalian NUMBER(9),
 10  constraint PK_transaksi primary key (Id_transaksi)
 11  );

Table created.
