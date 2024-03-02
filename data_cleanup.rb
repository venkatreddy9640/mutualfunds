require 'json'
require 'net/http'

def clean_data(file_content)
    data.reject { |ct| ct.strip.empty? }.select  { |ct| ct.include? ';'}
end

def map_isin(content)
#    uri_format = 'https://api.mfapi.in/mf/%s/latest'
    content.map { |ct| ct.split(';').reject { |ct| ct == '-' } }.map { |ct_arr| [ct_arr[0], ct_arr[1]] }
end

def map_scheme_data(content)
    uri_format = 'https://api.mfapi.in/mf/%s/latest'
    content.map do |code, isin|
        data = nil
        begin
            uri = URI(uri_format%code)
            data = Net::HTTP.get(uri)
            data = JSON.parse(data)
            puts "done for code #{code}"
        rescue => e
            print("Exception occurred for #{code} and #{isin}")
        end
        data
    end
end



f=open('fund_isin_data.csv', 'r')
data = f.readlines().map(&:chomp)
clean_data = data.reject { |ct| ct.strip.empty? }.select  { |ct| ct.include? ';'}
clean_data.map
