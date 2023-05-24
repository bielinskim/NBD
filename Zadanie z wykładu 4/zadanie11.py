import riak

client = riak.RiakClient(pb_port=8087)

bucket_name = 's26752'
bucket = client.bucket(bucket_name)

key = 'mb'
value = {'name':'Mateusz','age':30}
obj = bucket.new(key, data=value)
obj.store()

received_obj = bucket.get(key)
received_value = received_obj.data
print(received_value)

received_obj.data['name'] = 'MateuszAA'
received_obj.store()

received_obj = bucket.get(key)
received_value = received_obj.data
print(received_value)

received_obj.delete()

received_obj = bucket.get(key)
received_value = received_obj.data
print(received_value)
