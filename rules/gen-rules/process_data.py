import sys

def process_data(file1, file2, output_file):
    # Logic to process data from file1 and file2 and write to output_file
    with open(file1, 'r') as f1, open(file2, 'r') as f2, open(output_file, 'w') as out:
        data1 = f1.read()
        data2 = f2.read()
        out.write(data1 + data2)

if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: python process_data.py <input_file1> <input_file2> <output_file>")
        sys.exit(1)
    
    input_file1 = sys.argv[1]
    input_file2 = sys.argv[2]
    output_file = sys.argv[3]

    process_data(input_file1, input_file2, output_file)
