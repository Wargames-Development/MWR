import os

def dedupe_obj_groups():
    obj_path = input("Enter path to your .obj file: ").strip().strip('"')

    if not os.path.isfile(obj_path):
        print("❌ File not found.")
        return

    base_name = os.path.splitext(os.path.basename(obj_path))[0]
    output_path = f"deduped_{base_name}.obj"
    report_path = f"group_renaming_report_{base_name}.txt"

    group_counts = {}
    new_lines = []
    renaming_log = []

    with open(obj_path, 'r', encoding='utf-8') as f:
        for line in f:
            if line.startswith("o "):
                group_name = line.strip().split(" ", 1)[1]
                count = group_counts.get(group_name, 0)
                if count == 0:
                    # First occurrence, keep as-is
                    new_group = group_name
                else:
                    # Append _N for duplicates
                    new_group = f"{group_name}_{count}"
                    renaming_log.append(f"{group_name} → {new_group}")
                group_counts[group_name] = count + 1
                new_lines.append(f"o {new_group}\n")
            else:
                new_lines.append(line)

    # Save the cleaned OBJ
    with open(output_path, 'w', encoding='utf-8') as out_obj:
        out_obj.writelines(new_lines)

    # Save a renaming report
    with open(report_path, 'w', encoding='utf-8') as report:
        if renaming_log:
            report.write("Renamed duplicate groups:\n")
            for line in renaming_log:
                report.write(line + '\n')
        else:
            report.write("✅ No duplicates found. File was unchanged.\n")

    print(f"✅ Cleaned OBJ written to: {output_path}")
    print(f"📝 Renaming report written to: {report_path}")

# Run it
if __name__ == "__main__":
    dedupe_obj_groups()
