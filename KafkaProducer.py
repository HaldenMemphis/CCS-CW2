from kafka import KafkaProducer
import random
import string

# 设置Kafka的主题和服务器地址
topic = 'ccs-cw2-test'
bootstrap_servers = ['20.117.182.16:9092']

# 创建Kafka生产者
producer = KafkaProducer(bootstrap_servers=bootstrap_servers)

# 生成随机字符串
def random_string(length):
    letters = string.ascii_lowercase
    return ''.join(random.choice(letters) for i in range(length))

# 向Kafka发送消息
def send_message(msg):
    producer.send(topic, bytes(msg, 'utf-8'))

# 写入给定数量的随机消息
def write_messages(num_messages):
    for i in range(num_messages):
        msg = random_string(10)
        send_message(msg)
        print("ok")

# 写入100条随机消息
write_messages(10000)
