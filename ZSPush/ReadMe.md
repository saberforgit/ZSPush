1.ʹ�÷�����������������
@����һ��registPush ע�����ͷ���
���÷�ʽ��
 function registPush(){
        Push.registPush(function(res){JSON.stringify(res);},function(erro){alert(erro)});
        }

@��������logoutPush ȡ�����ͷ���
ʹ�÷�����
function logoutPush(){
Push.logoutPush(function(res){JSON.stringify(res);},function(erro){alert(erro)});
  }

���ص�����ȡ��ʵ��:{"status":"00","msg":"registComplete"},{"status":"00","msg":"logoutComplete"}

��Ҫ����Ҫ��js����Ӽ����¼����ڼ����Ļص��н�����Ϣ
����     
Push.on("receiveMsg", function (notification) {
                console.info(JSON.stringify(notification));
        });
ע�������������Ҫ��androidmainfest.xml�е�application��ǩ�����
     android:name="com.zsmarter.push.AppApplication"
