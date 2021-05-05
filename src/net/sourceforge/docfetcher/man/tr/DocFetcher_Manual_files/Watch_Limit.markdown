Klasör izleme sınırı nasıl yükseltilir (Linux)
===========================================

Linux'ta işlemler varsayılan olarak en fazla 8192 klasör izleyebilir. Çok derin bir klasör hiyerarşisini dizinlerseniz bu sınıra ulaşabilirsiniz. Böyle bir durumda, DocFetcher muhtemelen "Cihazda yer kalmadı" hata mesajı gösterecektir. İzleme sınırını artırarak bu sorunu çözebilirsiniz. Örneğin, bu komut geçici olarak saat sınırını 32000'e çıkaracaktır:

    sudo echo 32000 > /proc/sys/fs/inotify/max_user_watches

İzleme sınırını kalıcı olarak değiştirmek için `/etc/sysctl.conf` dosyasını (kök olarak) açın ve aşağıdaki satırı ekleyin:

    fs.inotify.max_user_watches=32000